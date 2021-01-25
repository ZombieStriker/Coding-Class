package me.danielle.nilsson.undeadengine;

import java.awt.event.KeyEvent;

public enum Key {
	UP_ARROW(KeyEvent.VK_UP),
	DOWN_ARROW(KeyEvent.VK_DOWN),
	LEFT_ARROW(KeyEvent.VK_LEFT),
	RIGHT_ARROW(KeyEvent.VK_RIGHT),
	SPACE(KeyEvent.VK_SPACE),
	ENTER(KeyEvent.VK_ENTER),
	ESCAPE(KeyEvent.VK_ESCAPE),
	BACKSPACE(KeyEvent.VK_BACK_SPACE),
	W(KeyEvent.VK_W, 'W'),
	A(KeyEvent.VK_A, 'A'),
	S(KeyEvent.VK_S, 'S'),
	D(KeyEvent.VK_D, 'D'),
	E(KeyEvent.VK_E, 'E'),
	C(KeyEvent.VK_C, 'C'),
	X(KeyEvent.VK_X, 'X'),
	Z(KeyEvent.VK_Z, 'Z'),
	F(KeyEvent.VK_F, 'F'),
	Q(KeyEvent.VK_Q, 'Q'),
	R(KeyEvent.VK_R, 'R'),
	T(KeyEvent.VK_T, 'T'),
	Y(KeyEvent.VK_Y, 'Y'),
	U(KeyEvent.VK_U, 'U'),
	I(KeyEvent.VK_I, 'I'),
	O(KeyEvent.VK_O, 'O'),
	P(KeyEvent.VK_P, 'P'),
	G(KeyEvent.VK_G, 'G'),
	H(KeyEvent.VK_H, 'H'),
	J(KeyEvent.VK_J, 'J'),
	K(KeyEvent.VK_K, 'K'),
	L(KeyEvent.VK_L, 'L'),
	V(KeyEvent.VK_V, 'V'),
	B(KeyEvent.VK_B, 'B'),
	N(KeyEvent.VK_N, 'N'),
	M(KeyEvent.VK_M, 'M'),
	ONE(KeyEvent.VK_1, '1'),
	TWO(KeyEvent.VK_2, '2'),
	THREE(KeyEvent.VK_3, '3'),
	FOUR(KeyEvent.VK_4, '4'),
	FIVE(KeyEvent.VK_5, '5'),
	SIX(KeyEvent.VK_6, '6'),
	SEVEN(KeyEvent.VK_7, '7'),
	EIGHT(KeyEvent.VK_8, '8'),
	NINE(KeyEvent.VK_9, '9'),
	ZERO(KeyEvent.VK_0, '0'),
	UNDERSCORE(KeyEvent.VK_UNDERSCORE, '_'),
	MINUS(KeyEvent.VK_MINUS, '-'),
	SUBTRACT(KeyEvent.VK_SUBTRACT, '-'),
	EQUALS(KeyEvent.VK_EQUALS, '='),
	PLUS(KeyEvent.VK_PLUS, '+'),
	TILDA(192, '~'),
	OPEN_BRACKET(KeyEvent.VK_OPEN_BRACKET, '['),
	CLOSE_BRACKET(KeyEvent.VK_CLOSE_BRACKET, ']'),
	COMMA(KeyEvent.VK_COMMA, ','),
	PERIOD(KeyEvent.VK_PERIOD, '.'),
	SEMICOLON(KeyEvent.VK_SEMICOLON, ';'),
	SHIFT(KeyEvent.VK_SHIFT),
	CAPSLOCK(KeyEvent.VK_CAPS_LOCK),
	SLASH(KeyEvent.VK_SLASH, '/'),
	BACK_SLASH(KeyEvent.VK_BACK_SLASH, '\\'),
	;

	int key;
	char character;
	boolean isCharacter = false;

	Key(int k) {
		this.key = k;
		this.character = ' ';
		this.isCharacter = false;
	}

	Key(int k, char c) {
		this.key = k;
		this.character = c;
		this.isCharacter = true;
	}

	public static Key getKey(int keyCode) {
		for (Key k : values()) {
			if (k.key == keyCode)
				return k;
		}
		return null;
	}

	public char getCharacter() {
		return character;
	}

	public boolean isCharacter() {
		return isCharacter;
	}
}
