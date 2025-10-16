package com.example.sbnz.model;

import com.example.sbnz.DTO.Kontinent;
import jakarta.persistence.*;

@Table(name="regions")
@Entity
public class Region
{
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    public String ime;
    public int vrednost;
    @Enumerated(EnumType.STRING)
    public Kontinent kontinent;

    public Region()
    {
        ime = "Jugoslavija";
        kontinent = Kontinent.EVROPA_I_SREDOZEMLJE;
    }
    public Region(String i, int v, Kontinent k)
    {
        ime = i;
        vrednost = v;
        kontinent = k;
    }
}
