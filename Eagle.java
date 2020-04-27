public class Eagle extends Bird implements Fly {

    // attributes
    private boolean flying;
    private int altitude;

    // constructors
    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    // getters and setters
    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    // methods abstraite
    @Override
    public String sing() {
        return "Screech!";
    }

    /**
     * TakeOff, must be on ground
     */
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /**
     * Fly ascend
     * @param meters altitude increase
     * @return altitude
     */
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 0);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

      /**
     * Fly descend
     * @param meters altitude decrease
     * @return downward
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

     /**
     * To Land, must be on the ground
     */
    @Override
    public void land() {
        if (this.flying && this.altitude < 10) {
            System.out.printf("%s lands on the ground %n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't lands. %n", this.getName());
        }
    }

         /**
     * To hover, must be on the ground
     */
    @Override
    public void glide() {
        if (this.flying) {
            System.out.printf("%s It glides into the air. %n", this.getName());
        }
    }
}
