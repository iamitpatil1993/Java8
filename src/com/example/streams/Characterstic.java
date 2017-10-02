package com.example.streams;

public class Characterstic {

	private String character;

	public Characterstic() {
		// Nothing to do here
	}

	public Characterstic(String character) {
		this.character = character;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Characterstic other = (Characterstic) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Characterstic [character=" + character + "]";
	}

}
