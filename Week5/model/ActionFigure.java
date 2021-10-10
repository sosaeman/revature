package Week5.model;

public class ActionFigure extends Doll {
	private String skill;

	
	 public ActionFigure() {
		 this.name="Venom";
		 this.eyeColor="black";
		 this.skill="symbyotic";
	}

	public ActionFigure(String name,String eyeColor,String skill) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
		this.skill = skill;

	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public void useSkill(){
		System.out.println( "Ka Pow! I�m using my skill,"+this.skill);
	};
}
