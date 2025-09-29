'use client';

import {RequestDTO} from './DTO/RequestDTO';
import {ResponseDTO} from './DTO/ResponseDTO';
import { useState } from 'react';

export default function Homepage()
{
    const [responseDTO, setResponseDTO] = useState(new ResponseDTO("N/A", "N/A", "N/A", "N/A", "N/A", 0, 0, 0, 0, 0));
    const [stilIgre, setStilIgre] = useState('OSVAJANJE');
    const [tezina, setTezina] = useState('POCETNIK');
    const [stabloMisija, setStabloMisija] = useState('NEBITNO');
    const [dostignuca, setDostignuca] = useState('NEBITNO');
    const [kontinent, setKontinent] = useState('EVROPA_I_SREDOZEMLJE');

    const handleStilIgreChange = (value: string) => {
        setStilIgre(value.toUpperCase());
    }

    const handleTezinaChange = (value: string) => {
        setTezina(value.toUpperCase());
    }

    const handleStabloMisijaChange = (value: string) => {
        setStabloMisija(value.toUpperCase());
    }

    const handleDostignucaChange = (value: string) => {
        setDostignuca(value.toUpperCase());
    }

    const handleKontinentChange = (value: string) => {
        if(value == "Evropa i sredozemlje")
            setKontinent("EVROPA_I_SREDOZEMLJE");
        if(value == "Azija")
            setKontinent("AZIJA");
        if(value == "Subsaharska Afrika")
            setKontinent("SUBSAHARSKA_AFRIKA");
        if(value == "Novi Svet")
            setKontinent("NOVI_SVET");
    }

    const button_request = async () => 
    {
        console.log(JSON.stringify(new RequestDTO(stilIgre, tezina, stabloMisija, dostignuca, kontinent)));
        try
        {
            const response = await fetch('http://localhost:8080/api/rules',
                                            {method: 'POST',
                                            headers: {
                                            'Content-Type': 'application/json',
                                            'Accept': 'application/json' // Often good practice to include Accept header too
                                            },
                                            body: JSON.stringify(new RequestDTO(stilIgre, tezina, stabloMisija, dostignuca, kontinent))});
            if (!response.ok)
            {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const json = await response.json();
            setResponseDTO(new ResponseDTO(json.name1, json.name2, json.name3, json.name4, json.name5,
                json.score1, json.score2, json.score3, json.score4, json.score5));
        }
        catch (err)
        {
            console.log(err);
        }
    }

    return <div>
    <select name="stilIgre" onChange={event => handleStilIgreChange(event.target.value)}>
        <option>Osvajanje</option>
        <option>Diplomatija</option>
        <option>Trgovina</option>
        <option>Kolonizacija</option>
    </select><br/>
    <select name="tezina" onChange={event => handleTezinaChange(event.target.value)}>
        <option>Pocetnik</option>
        <option>Osrednji</option>
        <option>Iskusni</option>
        <option>Strucnjak</option>
    </select><br/>
    <select name="stabloMisija" onChange={event => handleStabloMisijaChange(event.target.value)}>
        <option>Nebitno</option>
        <option>Grupno</option>
        <option>Jedinstveno</option>
    </select><br/>
    <select name="dostignuca" onChange={event => handleDostignucaChange(event.target.value)}>
        <option>Nebitno</option>
        <option>Bitno</option>
    </select><br/>
    <select name="kontinent" onChange={event => handleKontinentChange(event.target.value)}>
        <option>Evropa i Sredozemlje</option>
        <option>Azija</option>
        <option>Subsaharska Afrika</option>
        <option>Novi Svet</option>
    </select><br/>
    <button onClick={button_request}>Find best countries</button><br/>
    <p>{responseDTO.name1} {responseDTO.score1}</p>
    <p>{responseDTO.name2} {responseDTO.score2}</p>
    <p>{responseDTO.name3} {responseDTO.score3}</p>
    <p>{responseDTO.name4} {responseDTO.score4}</p>
    <p>{responseDTO.name5} {responseDTO.score5}</p>
    </div>
}