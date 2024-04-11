package main;

import enemies.Minions;
import object.OBJ_Health;
import object.OBJ_MonsterDrop;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;
    }

    public void setObject() {
        //Use array slot to dictate position and movement of particular element
    //gp.obj[0] = new OBJ_MonsterDrop[]
    }

    public void setMinions( ) {
        //Add for loop that iterates x number of monsters using "i (first row of minions)"
        gp.Minions[0] = new Minions(gp);
        gp.Minions[0].x = gp.unitSize*21;
        gp.Minions[0].y = gp.unitSize*21;

        gp.Minions[1] = new Minions(gp);
        gp.Minions[1].x = gp.unitSize*21;
        gp.Minions[1].y = gp.unitSize*11;

        gp.Minions[2] = new Minions(gp);
        gp.Minions[2].x = gp.unitSize*11;
        gp.Minions[2].y = gp.unitSize*21;

        gp.Minions[1] = new Minions(gp);
        gp.Minions[1].x = gp.unitSize*41;
        gp.Minions[1].y = gp.unitSize*11;

    }

}
