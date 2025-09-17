package com.example.sbnz.DTO;

public class ResponseDTO
{
    private String name1, name2, name3, name4, name5;
    private int score1, score2, score3, score4, score5;

    public ResponseDTO(String n1, String n2, String n3, String n4, String n5, int s1, int s2, int s3, int s4, int s5)
    {
        super();

        name1 = n1;
        name2 = n2;
        name3 = n3;
        name4 = n4;
        name5 = n5;

        score1 = s1;
        score2 = s2;
        score3 = s3;
        score4 = s4;
        score5 = s5;
    }
}
