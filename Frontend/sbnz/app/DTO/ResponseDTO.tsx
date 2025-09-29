export class ResponseDTO
{
    name1: string;
    name2: string;
    name3: string;
    name4: string;
    name5: string;

    score1: number;
    score2: number;
    score3: number;
    score4: number;
    score5: number;

    constructor(name1: string, name2: string, name3: string, name4: string, name5: string,
        score1: number, score2: number, score3: number, score4: number, score5: number)
    {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;

        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.score5 = score5;
    }
}