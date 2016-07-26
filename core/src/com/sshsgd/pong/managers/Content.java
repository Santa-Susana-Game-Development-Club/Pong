package com.sshsgd.pong.managers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Content {

	private HashMap<String, Sound> sound;
	private HashMap<String, BitmapFont> font;
	GlyphLayout gl;
	
	public Content() {
		sound = new HashMap<String, Sound>();
		font = new HashMap<String, BitmapFont>();
		gl = new GlyphLayout();
	}
	
	/*
	 * Sound
	 */
	
	public void loadSound(String folder, String path, String key) {
		Sound s = Gdx.audio.newSound(Gdx.files.internal(folder + "/" + path));
		sound.put(key, s);
	}
	
	public Sound getSound(String key) {
		return sound.get(key);
	}
	
	public void playSound(String key) {
		sound.get(key).play(.8f);
	}
	
	/*
	 * Bitmap Font
	 */
	public void loadBitmapFont(String folder, String path, String key, int size, Color color, Color shadowColor) {
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal(folder + "/" + path));
		FreeTypeFontParameter param = new FreeTypeFontParameter();
		param.size = size;
		param.color = color;
		param.shadowOffsetX = 3;
		param.shadowOffsetY = 3;
		param.shadowColor = shadowColor;
		BitmapFont bmf = gen.generateFont(param);
		font.put(key, bmf);
		gen.dispose();
	}
	
	public void loadBitmapFont(String folder, String path, String key, int size, Color color) {
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal(folder + "/" + path));
		FreeTypeFontParameter param = new FreeTypeFontParameter();
		param.size = size;
		param.color = color;
		BitmapFont bmf = gen.generateFont(param);
		font.put(key, bmf);
		gen.dispose();
	}
	
	public BitmapFont getFont(String key) {
		return font.get(key);
	}

	public float getWidth(String key, String s, float targetWidth, int halign, boolean wrap) {
		gl.setText(font.get(key), s, font.get(key).getColor(), targetWidth, halign, wrap);
		return gl.width;
	}
	
	public float getHeight(String key, String s, float targetWidth, int halign, boolean wrap) {
		gl.setText(font.get(key), s, font.get(key).getColor(), targetWidth, halign, wrap);
		return gl.height - font.get(key).getDescent();
	}
	
	/*
	 * Other
	 */
	
	public void removeAll() {
		for(Object o : sound.values()) {
			Sound s = (Sound) o;
			s.dispose();
		}
		for(Object o : font.values()) {
			BitmapFont bmf = (BitmapFont) o;
			bmf.dispose();
		}
		sound.clear();
		font.clear();
	}
	
	public void stopSound() {
		for(Object o : sound.values()) {
			Sound s = (Sound) o;
			s.stop();
		}
	}
	
	public void stopAllSound() {
		stopSound();
	}
	
}
