package com.Swingy.Controller.Heros;

public class HeroStart {
	
	public HeroStart()
	{	
	}
	
	public static HeroDetails newHero(String heroName, String heroClass, int heroLevel, int heroAttack, int heroExp, int heroDefense, int heroHP)
	{
		if (heroClass.toLowerCase().equals("warrior"))
		{
			return new WarriorHero(heroName, heroClass, heroLevel, heroAttack, heroExp, heroDefense, heroHP);
		} else if (heroClass.toLowerCase().equals("legend"))
		{
			return new LegendHero(heroName, heroClass, heroLevel, heroAttack, heroExp, heroDefense, heroHP);
		} else if (heroClass.toLowerCase().equals("healer"))
		{
			return new HealerHero(heroName, heroClass, heroLevel, heroAttack, heroExp, heroDefense, heroHP);
		}
		
		return null;
	}

}
