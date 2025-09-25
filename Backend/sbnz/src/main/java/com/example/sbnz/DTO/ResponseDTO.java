package com.example.sbnz.DTO;

public class ResponseDTO
{
    public String name1, name2, name3, name4, name5;
    public int score1, score2, score3, score4, score5;

    public ResponseDTO()
    {
        name1 = "N/A";
        name2 = "N/A";
        name3 = "N/A";
        name4 = "N/A";
        name5 = "N/A";

        score1 = -1;
        score2 = -1;
        score3 = -1;
        score4 = -1;
        score5 = -1;
    }

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

    public void insert(String name, int score)
    {
        if(score > score5)
        {
            name5 = name;
            score5 = score;
        }
        if(score > score4)
        {
            name5 = name4;
            score5 = score4;
            name4 = name;
            score4 = score;
        }
        if(score > score3)
        {
            name4 = name3;
            score4 = score3;
            name3 = name;
            score3 = score;
        }
        if(score > score2)
        {
            name3 = name2;
            score3 = score2;
            name2 = name;
            score2 = score;
        }
        if(score > score1)
        {
            name2 = name1;
            score2 = score1;
            name1 = name;
            score1 = score;
        }
    }
}
