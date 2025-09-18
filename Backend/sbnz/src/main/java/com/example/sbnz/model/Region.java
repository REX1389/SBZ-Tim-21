package com.example.sbnz.model;

import com.example.sbnz.DTO.Kontinent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="regions")
@Entity
public class Region
{
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    public String ime;
    public Kontinent kontinent;

    public Region()
    {
        ime = "Jugoslavija";
        kontinent = Kontinent.EVROPA_I_SREDOZEMLJE;
    }
    public Region(String i, Kontinent k)
    {
        ime = i;
        kontinent = k;
    }
}
