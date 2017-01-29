package interpreter;

import interpreter.ID;

public class MemoryStorage {
	private int[] mem;
	ID var;

	public MemoryStorage() {
		mem = new int[26];
	}

	public int fetch(ID var) {
		return mem[id2Index(var)];
	}

	public void store(ID var, int value) {
		mem[id2Index(var)] = value;
	}

	private int id2Index(ID varIdDvar) {

		return Character.toLowerCase(var.getVar().charAt(0)) - 'a';
	}
}
