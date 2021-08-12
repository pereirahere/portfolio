package streetFighter.fighters;

public enum Fighters {

    SARA(5, 100),
    PEDRO(50, 100),
    PAULO(5, 100),
    JEANMARK(1, 100);


    private int damage;
    private int health;



    Fighters(int damage, int health) {
        this.damage = damage;
        this.health = health;
    }


    public static int getDamage(Fighters champion) {

        switch (champion) {
            case SARA:
                return SARA.damage;
            case PAULO:
                return PAULO.damage;
            case PEDRO:
                return PEDRO.damage;
            case JEANMARK:
                return JEANMARK.damage;
            default:
                return 0;

        }

    }


    public static int getInitialHealth(Fighters champion) {

        switch (champion) {
            case SARA:
                return SARA.health;
            case PAULO:
                return PAULO.health;
            case PEDRO:
                return PEDRO.health;
            case JEANMARK:
                return JEANMARK.health;
            default:
                return 0;

        }

    }


    public static String getPhotoName(Fighters champion){

        switch (champion) {
            case SARA:
                return "sara";
            case PAULO:
                return "paulo";
            case PEDRO:
                return "pedro";
            case JEANMARK:
                return "igreja";
            default:
                return "Fudeu";

        }

    }
}



