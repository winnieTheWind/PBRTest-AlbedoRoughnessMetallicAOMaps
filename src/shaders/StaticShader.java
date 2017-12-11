package shaders;

import models.TexturedModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Matrix;
import org.lwjgl.util.vector.Matrix4f;

import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector3f;
import toolbox.Maths;

import entities.Camera;

public class StaticShader extends ShaderProgram{

	float MAX_LIGHTS = 4;

	private static final String VERTEX_FILE = "src/shaders/pbrtesttex.vert";
	private static final String FRAGMENT_FILE = "src/shaders/pbrtesttex.frag";

	//locations ex. private int location_transformationMatrix;

	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_model;

	private int location_albedo;
	private int location_metallic;
	private int location_roughness;
	private int location_ao;
	private int location_lightPosition;
	private int location_lightColour;
	//private int location_lightPosition[];
	//private int location_lightColour[];

	private float metallic;
	private float roughness;
	private float albedoR;
	private float albedoG;
	private float albedoB;
	private float lightX;
	private float lightY;
	private float lightZ;
	private float ao;

	private TexturedModel model;
	public StaticShader()
	{
		super(VERTEX_FILE, FRAGMENT_FILE);

	}

	@Override
	protected void bindAttributes() {
		//bind attributes ex super.bindAttribute(0, "position");

		//super.bindAttribute(0, "position");
		//super.bindAttribute(1, "textureCoordinates");

		super.bindAttribute(0, "aPos");
		super.bindAttribute(1, "aTexCoords");
		super.bindAttribute(2, "aNormal");

	}

	@Override
	protected void getAllUniformLocations() {
		// uniform locations ex. location_transformationMatrix = super.getUniformLocation("transformationMatrix");

		//location_transformationMatrix = super.getUniformLocation("model");
		location_model = super.getUniformLocation("model");
		location_projectionMatrix = super.getUniformLocation("projection");
		location_viewMatrix = super.getUniformLocation("view");


		location_albedo = super.getUniformLocation("albedoMap");
		location_metallic = super.getUniformLocation("metallicMap");
		location_roughness = super.getUniformLocation("roughnessMap");
		location_ao = super.getUniformLocation("aoMap");

		location_lightPosition = super.getUniformLocation("lightPositions");
		location_lightColour = super.getUniformLocation("lightColors");
		//for(int i=0;i<MAX_LIGHTS;i++) {
		//	location_lightPosition[i] = super.getUniformLocation("lightPositions[" + i + "]");
		//	location_lightColour[i] = super.getUniformLocation("lightColors[" + i + "]");
		//}
	}


	public void loadPBR() {



		//super.loadVector(location_albedo, );
		//super.loadFloat(location_metallic, 0);
		//super.loadFloat(location_roughness, 0);
		//super.loadFloat(location_ao, 10);
		//super.loadVector(location_lightPosition, new Vector3f(0,0,0));
		//super.loadVector(location_lightColour, new Vector3f(255,255,255));

		if(Keyboard.isKeyDown(Keyboard.KEY_P)){
			roughness = roughness + 0.01f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_O)){
			roughness = roughness - 0.01f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_E)){
			albedoG = albedoG + 0.01f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_T)){
			albedoB = albedoB + 0.01f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_Y)){
			albedoR = albedoR + 0.01f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_N)){
			lightY = lightY + 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_M)){
			lightY = lightY - 1f;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_H)){
			ao = ao + 1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_J)){
			ao = ao - 1f;
		}
	}
	
	public void loadTransformationMatrix(Matrix4f matrix){
		// ex. super.loadMatrix(location_transformationMatrix, matrix);
		super.loadMatrix(location_model, matrix);

	}
	
	public void loadViewMatrix(Camera camera){
		// ex. 		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		// 			super.loadMatrix(location_viewMatrix, viewMatrix);
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection){
		// ex. super.loadMatrix(location_projectionMatrix, projection);
		super.loadMatrix(location_projectionMatrix, projection);
	}

}
