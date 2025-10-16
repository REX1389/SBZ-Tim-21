package com.example.sbnz.model;

import com.example.sbnz.DTO.StabloMisija;
import jakarta.persistence.*;

@Table(name="countires")
@Entity
public class Country
{
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    public String ime;
    public int bonusi_vojni;
    public int bonusi_pomorski;
    public int bonusi_ekonomski;
    public int bonusi_diplomatski;
    public int dostignuca;
    public boolean diplomatska_institucija;
    @Enumerated(EnumType.STRING)
    public StabloMisija stabloMisija;
    @Enumerated(EnumType.STRING)
    public SnagaDrzave snagaDrzave;
    public String regionIme;

    public Country()
    {
        ime = "Jugoslavija";
        bonusi_vojni = 3;
        bonusi_pomorski = 1;
        bonusi_ekonomski = 2;
        bonusi_diplomatski = 1;
        dostignuca = 3;
        diplomatska_institucija = false;
        stabloMisija = StabloMisija.JEDINSTVENO;
        snagaDrzave = SnagaDrzave.OSREDNJA;
        regionIme = "Jugoslavija";
    }

    public Country(String i, int bv, int bp, int be, int bd, int d, boolean di, StabloMisija sm, SnagaDrzave sd, String r)
    {
        ime = i;
        bonusi_vojni = bv;
        bonusi_pomorski = bp;
        bonusi_ekonomski = be;
        bonusi_diplomatski = bd;
        dostignuca = d;
        diplomatska_institucija = di;
        stabloMisija = sm;
        snagaDrzave = sd;
        regionIme = r;
    }
}
