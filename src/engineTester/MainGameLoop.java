package engineTester;

import models.RawModel;
import models.TexturedModel;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;
import entities.Camera;
import entities.Entity;

public class MainGameLoop {



	public static void main(String[] args) {


		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		RawModel model = OBJLoader.loadObjModel("sphere", loader);

		ModelTexture albedo = new ModelTexture(loader.loadTexture("oakfloor_basecolor"));
		ModelTexture roughness = new ModelTexture(loader.loadTexture("oakfloor_roughness"));
		ModelTexture metallic = new ModelTexture(loader.loadTexture("oakfloor_normal"));
		ModelTexture ao = new ModelTexture(loader.loadTexture("oakfloor_AO"));
		
		TexturedModel staticModel = new TexturedModel(model,albedo, roughness, metallic, ao);

		
		Entity entity = new Entity(staticModel, new Vector3f(0,0,-30),0,0,0,1);
		
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()){
			entity.increaseRotation(0, -0.3f, 0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}

		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
