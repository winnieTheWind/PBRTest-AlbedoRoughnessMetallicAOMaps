package models;

import textures.ModelTexture;

public class TexturedModel {
	
	private RawModel rawModel;
	private ModelTexture albedo;
	private ModelTexture roughness;
	private ModelTexture metallic;
	private ModelTexture ao;

	
	public TexturedModel(RawModel model, ModelTexture albedo){
		this.rawModel = model;
		this.albedo = albedo;

	}

	public TexturedModel(RawModel model, ModelTexture albedo, ModelTexture roughness, ModelTexture metallic, ModelTexture ao){
		this.rawModel = model;
		this.albedo = albedo;
		this.roughness = roughness;
		this.metallic = metallic;
		this.ao = ao;

	}

	public RawModel getRawModel() {
		return rawModel;
	}

	public ModelTexture getAlbedo() {
		return albedo;
	}


	public ModelTexture getRoughness() {
		return roughness;
	}


	public ModelTexture getMetallic() {
		return metallic;
	}


	public ModelTexture getAo() {
		return ao;
	}





}
