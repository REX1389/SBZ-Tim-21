package com.example.sbnz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.kie.api.definition.type.Position;

@Table(name="grane")
@Entity
public class Grana
{
    @Id
    @Column(nullable = false, updatable = false, unique = true)
    public Long id;
    @Position(0)
    public String regionOd;

    @Position(1)
    public String regionDo;

    public Grana()
    {
        regionOd = "N/A";
        regionDo = "N/A";
    }
    public Grana(String rod, String rdo)
    {
        regionOd = rod;
        regionDo = rdo;
    }
}
