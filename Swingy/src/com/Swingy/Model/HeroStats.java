package com.Swingy.Model;

public class HeroStats {
	private String _HeroName;
	private String _HeroClass;
	private int _HeroLevel;
	private int _HeroExp;
	private int _HeroAttack;
	private int _HeroDefense;
	private int _HeroHP;
	
	public HeroStats(String _HeroName, String _HeroClass, int _HeroLevel, int _HeroExp, int _HeroDefense, int _HeroHP)
	{
		this._HeroName = _HeroName;
		this._HeroClass = _HeroClass;
		this._HeroLevel = _HeroLevel;
		this._HeroExp = _HeroExp;
		this._HeroDefense = _HeroDefense;
		this._HeroHP = _HeroHP;		
	}

	public String get_HeroName() {
		return _HeroName;
	}

	public void set_HeroName(String _HeroName) {
		this._HeroName = _HeroName;
	}

	public String get_HeroClass() {
		return _HeroClass;
	}

	public void set_HeroClass(String _HeroClass) {
		this._HeroClass = _HeroClass;
	}

	public int get_HeroLevel() {
		return _HeroLevel;
	}

	public void set_HeroLevel(int _HeroLevel) {
		this._HeroLevel = _HeroLevel;
	}

	public int get_HeroExp() {
		return _HeroExp;
	}

	public void set_HeroExp(int _HeroExp) {
		this._HeroExp = _HeroExp;
	}

	public int get_HeroAttack() {
		return _HeroAttack;
	}

	public void set_HeroAttack(int _HeroAttack) {
		this._HeroAttack = _HeroAttack;
	}

	public int get_HeroDefense() {
		return _HeroDefense;
	}

	public void set_HeroDefense(int _HeroDefense) {
		this._HeroDefense = _HeroDefense;
	}

	public int get_HeroHP() {
		return _HeroHP;
	}

	public void set_HeroHP(int _HeroHP) {
		this._HeroHP = _HeroHP;
	}

}
