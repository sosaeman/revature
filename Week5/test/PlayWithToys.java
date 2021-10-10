package Week5.test;

import Week5.model.Doll;
import Week5.model.ActionFigure;



public class PlayWithToys {

	 public static void main(String[] args) {
	      Doll doll = new Doll("Annabelle","blue");
	      System.out.println("Our doll "+doll.getName()
	                    +" has "+doll.getEyeColor()+" eyes.");
	      doll.play();
	      doll.makeTalk();
	  //----------------------------
		 ActionFigure hero = new ActionFigure( "Barry Allan", "blue","speed");
		 System.out.println("Our action figure " + hero.getName() + " has " + hero.getEyeColor() + " eyes and " + hero.getSkill() + " skill.");
		 hero.makeTalk();
		 hero.play();
		 hero.useSkill();
	 }
}
