import java.util.Random;

enum Category {
    INVALID,
    LIGHTWEIGHT,
    MIDDLE_WEIGHT,
    HEAVY_WEIGHT
}


    public class Fighter {
        private String name;
        private String nationality;
        private int age;
        private float height;
        private float weight;
        private Category category;
        private int win;
        private int lose;
        private int aTie;
        private int life;
        private boolean approved;
        private Fighter challenger;
        private Fighter challenged;
        private int Rounds;


        public Fighter(String name, String nationality, int age, float height, float weight,
                       int win, int lose, int aTie, int life) {
            this.name = name;
            this.nationality = nationality;
            this.age = age;
            this.height = height;
            this.setWeight(weight);
            this.win = win;
            this.lose = lose;
            this.aTie = aTie;
            this.life = life;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nat) {
            this.nationality = nationality;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
            setCategory();
        }

        public Category getCategory() {
            return category;
        }

        private void setCategory() {
            if (this.weight <= 52.2) {
                this.category = Category.INVALID;
            } else if (this.weight <= 70.3) {
                this.category = Category.LIGHTWEIGHT;
            } else if (this.weight <= 83.9) {
                this.category = Category.MIDDLE_WEIGHT;
            } else if (this.weight <= 120.2) {
                this.category = Category.HEAVY_WEIGHT;
            } else {
                this.category = Category.INVALID;
                //The fighter's health is based on his category being 80 for Lightweight,
                // 95 for Middleweight and 110 for Heavyweight
            }

        }


        public int getWin() {
            return win;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public int getLose() {
            return lose;
        }

        public void setLose(int lose) {
            this.lose = lose;
        }

        public int getaTie() {
            return aTie;
        }

        public void setaTie(int aTie) {
            this.aTie = aTie;
        }

        public int getLife() {
            return life;
        }

        public void setLife(int life) {
            this.life = life;
        }

        public void winFight() {
            this.setWin(this.getWin() + 1);
        }

        public void loseFight() {
            this.setLose(this.getLose() + 1);
        }

        public Fighter getChallenged() {
            return challenged;
        }

        public void setChallenged(Fighter challenged) {
            this.challenged = challenged;
        }

        public Fighter getChallenger() {
            return challenger;
        }

        public void setChallenger(Fighter challenger) {
            this.challenger = challenger;
        }

        public int getRounds() {
            return Rounds;
        }

        public void setRounds(int rounds) {
            Rounds = rounds;
        }

        public boolean getApproved() {
            return approved;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }

        public void present() {
            System.out.println("the name of fighter is " + this.getName() + "!");
            System.out.println("he comes from " + this.getNationality());
            System.out.println("fighter's age " + this.getAge());
            System.out.println("he is " + this.getHeight() + " height");
            System.out.println("and your weight is " + this.getWeight());
            System.out.println("won " + this.getWin() + " fights");
            System.out.println("it lost " + this.getLose() + " fights");
            System.out.println("and a tie " + this.getaTie() + " fights");
        }

        public void status() {
            System.out.println("his category is " + this.getCategory());
            System.out.println("wons " + this.getWin());
            System.out.println("it lost " + this.getLose());
            System.out.println("and a tie " + this.getaTie());
        }

        public void attack(Fighter rival) {
            Random random = new Random();
            int damage = random.nextInt(10) + 1;
            if (life > 0) {
                rival.setLife(rival.getLife() - damage);
                System.out.println(name + " hits fighter " + rival.getName() +
                        " with a blow of " + damage + " of damage");
                System.out.println(rival.getName() + " now has " + rival.getLife() + " of life");
            }


        }

        public boolean stayAlive() {
            return life > 0;
        }

        public void scheduleFight(Fighter fighter, Fighter fighter1) {
            if (fighter.getCategory().equals(fighter1.getCategory())
                    && fighter != fighter1) {
                this.approved = true;
                this.challenged = fighter;
                this.challenger = fighter1;
            } else {
                this.approved = false;
                this.challenged = null;
                this.challenger = null;
            }
        }

        public void toFight() {
            if (this.approved) {
                System.out.println("---CHALLENGED---");
                this.challenged.present();
                System.out.println("---CHALLENGER---");
                this.challenger.present();
            }
        }

        public void fighting(Fighter[] fighter) {
            int roundOfFight = 1;
            while (fighter[0].stayAlive() && fighter[1].stayAlive()) {
                System.out.println("===Round " + roundOfFight + " ====");
                fighter[0].attack(fighter[1]);

                if (!fighter[1].stayAlive()) {
                    break;
                }
                fighter[1].attack(fighter[0]);
                if (!fighter[0].stayAlive()) {
                    break;
                }
                roundOfFight++;


            }
        }

        public void defineWinnerAndLoser(Fighter[] fighter) {
            if (fighter[0].stayAlive()) {
                System.out.println(fighter[0].getName() + " won a fight!");
                fighter[0].winFight();
                fighter[0].status();
                System.out.println("========================");
                fighter[1].loseFight();
                fighter[1].status();
                System.out.println("========================");
            } else {
                System.out.println(fighter[1].getName() + " won a fight!");
                fighter[1].winFight();
                fighter[1].status();
                System.out.println("========================");
                fighter[0].loseFight();
                fighter[0].status();
                System.out.println("========================");

            }
        }
    }


