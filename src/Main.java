public class Main {
    public static void main(String[] args) {
        Fighter fighter[] = new Fighter[6];

        fighter[0] = new Fighter("Pretty boy", "France", 31, 1.75f, 68.9f, 11, 3, 1, 88);

        fighter[1] = new Fighter("Putscript", "Brazil", 29, 1.68f, 57.8f, 14, 2, 3, 82);

        fighter[2] = new Fighter("Snapshadow", "EUA", 35, 1.65f, 80.9f, 12, 2, 1, 106);

        fighter[3] = new Fighter("Dead code", "Australia", 28, 1.93f, 81.6f, 13, 0, 2, 107);

        fighter[4] = new Fighter("UFOcobol", "Brazil", 37, 1.70f, 119.3f, 5, 4, 3, 130);

        fighter[5] = new Fighter("Nerdaart", "EUA", 30, 1.81f, 105.7f, 12, 2, 4, 120);


        fighter[0].scheduleFight(fighter[0], fighter[1]);
        fighter[0].toFight();
        fighter[0].fighting(fighter);
        fighter[0].defineWinnerAndLoser(fighter);




    }
}
