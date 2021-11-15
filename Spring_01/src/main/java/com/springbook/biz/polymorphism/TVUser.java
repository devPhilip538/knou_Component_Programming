package com.springbook.biz.polymorphism;

public class TVUser {
	public static void main (String args[]) {
//		삼성 TV
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

//		엘지 TV 객체
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
		
	}
}
