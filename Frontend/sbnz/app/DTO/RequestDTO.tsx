export class RequestDTO
{
    stilIgre: string;
    tezina: string;
    stabloMisija: string;
    dostignuca: string;
    kontinent: string;

    constructor(stilIgre: string, tezina: string, stabloMisija: string, dostignuca: string, kontinent: string)
    {
        this.stilIgre = stilIgre;
        this.tezina = tezina;
        this.stabloMisija = stabloMisija;
        this.dostignuca = dostignuca;
        this.kontinent = kontinent;
    }
}