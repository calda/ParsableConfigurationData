package com.caldabeast.pcd;

import java.util.Scanner;

import com.caldabeast.pcd.databit.*;

public class Tester {

	public static void main(String[] args) throws PCDUnallowedException{
		ParsableModule loc = new ParsableModule("Location");
		loc.addNewDatabit(new FloatData("x", 10.23f));
		loc.addNewDatabit(new FloatData("y", 11.23f));
		loc.addNewDatabit(new FloatData("z", 9919.0f));
		loc.addNewDatabit(new FloatData("pitch", 10f));
		loc.addNewDatabit(new FloatData("yaw", 100f));
		loc.addNewDatabit(new StringData("worldName", "World_nether"));
		System.out.println(loc.getParsedString());
		UnparsedModule unLoc = new UnparsedModule(loc.getParsedString());
		System.out.println(unLoc.toString());
		ParsableConfigurationData pcd = new ParsableConfigurationData("woopwoop");
		pcd.addNewData(new StringData("name", "spawnA"));
		pcd.addNewData(loc);
		System.out.println(pcd.getParsedString());
		UnparsedConfigurationData ucd = new UnparsedConfigurationData(pcd.getParsedString());
		System.out.println(ucd);
		System.out.println(ucd.getModule("Location").getFloat("yaw"));
		Scanner s = new Scanner(System.in);
		System.out.print("Enter data to unparse: ");
		String unparse = s.nextLine();
		ucd = new UnparsedConfigurationData(unparse);
		System.out.println(ucd);
	}
}
