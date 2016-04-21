import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

import aston.nabneyit.model.*;
import aston.nabneyit.view.*;

/**
 * A simple predator-prey simulator, based on a field containing
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2002-04-09
 * @author Ian T. Nabney
 * @version 30-01-2005
 * @author Ian T. Nabney
 * @version 13-02-2005
 */
public class Simulator
{
	// The private static final variables represent 
	// configuration information for the simulation.
	// The default width for the grid.
	private static final int DEFAULT_WIDTH = 50;
	// The default depth of the grid.
	private static final int DEFAULT_DEPTH = 50;
	// The probability that a fox will be created in any given grid position.
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	// The probability that a rabbit will be created in any given grid position.
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;    
	// The probability that a hunter will be created in any given grid position.
	private static final double HUNTER_CREATION_PROBABILITY = 0.01;
	
	// The list of actors in the field
	private List<Actor> actors;
	// The list of actors just born
	private List<Actor> newActors;
	// The current state of the field.
	private Field field;
	// A second field, used to build the next stage of the simulation.
	private Field updatedField;
	// The current step of the simulation.
	private int step;
	// Multiple view of the simulation
	private SimulatorView[] views;
	
	/**
	 * Create a simulation and run it for a specified number of steps
	 */
	public static void main(String[] args) {
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0) 
			numSteps = 1;
		
		int seed = 42;  // By default, use a seed of 42
		if (args.length >= 2) {
			seed = Integer.parseInt(args[1]);
		}
		Simulator s = new Simulator(seed);
		
		s.simulate(numSteps);
	}
	
	/**
	 * Construct a simulation field with default size.
	 */
	public Simulator(int seed)
	{
		this(DEFAULT_DEPTH, DEFAULT_WIDTH, seed);
	}
	
	/**
	 * Create a simulation field with the given size.
	 * @param depth Depth of the field. Must be greater than zero.
	 * @param width Width of the field. Must be greater than zero.
	 */
	public Simulator(int depth, int width, int seed)
	{
		if(width <= 0 || depth <= 0) {
			System.out.println("The dimensions must be greater than zero.");
			System.out.println("Using default values.");
			depth = DEFAULT_DEPTH;
			width = DEFAULT_WIDTH;
		}
		
		actors = new ArrayList<Actor>();
		newActors = new ArrayList<Actor>();
		field = new Field(depth, width);
		updatedField = new Field(depth, width);
		
		// Create a view of the state of each location in the field.
		views = new SimulatorView[2];
		views[0] = new AnimatedView(depth, width);
		views[1] = new TextView();
		for (int i = 0; i < views.length; i++) {
			views[i].registerClass(Fox.class);
			views[i].registerClass(Rabbit.class);
			views[i].registerClass(Hunter.class);
		}
		
		// Setup a valid starting point.
		reset(seed);
	}
	
	/**
	 * Run the simulation from its current state for a reasonably long period,
	 * e.g. 500 steps.
	 */
	public void runLongSimulation()
	{
		simulate(500);
	}
	
	/**
	 * Run the simulation from its current state for the given number of steps.
	 * Stop before the given number of steps if it ceases to be viable.
	 */
	public void simulate(int numSteps)
	{
		for(int step = 1; step <= numSteps && field.isViable(); step++) {
			simulateOneStep();
		}
	}
	
	/**
	 * Run the simulation from its current state for a single step.
	 * Iterate over the whole field updating the state of each
	 * actor.
	 */
	public void simulateOneStep()
	{
		step++;
		newActors.clear();
		
		// let all actors act
		for(Iterator<Actor> iter = actors.iterator(); iter.hasNext(); ) {
			Actor actor = iter.next();
			if (actor.isAlive()) {
				actor.act(field, updatedField, newActors);
			}
			else {
				iter.remove();   // remove dead actors from collection
			}
		}
		// add new born actors to the list of actors
		actors.addAll(newActors);
		
		// Swap the field and updatedField at the end of the step.
		Field temp = field;
		field = updatedField;
		updatedField = temp;
		updatedField.clear();
		// All the counts need to be recalculated
		field.reset();  
		
		// display the new field on screen
		for (int i = 0; i < views.length; i++) {
			views[i].showStatus(step, field);
		}
	}
	
	/**
	 * Reset the simulation to a starting position.
	 */
	public void reset(int seed)
	{
		step = 0;
		actors.clear();
		field.clear();
		field.reset();
		updatedField.clear();
		populate(field, seed);
		
		// Show the starting state in the view.
		for (int i = 0; i < views.length; i++) {
			views[i].showStatus(step, field);
		}
	}
	
	/**
	 * Populate the field with foxes, rabbits and hunters.
	 */
	private void populate(Field field, int seed)
	{
		Random rand = new Random(seed);
		field.clear();
		for(int row = 0; row < field.getDepth(); row++) {
			for(int col = 0; col < field.getWidth(); col++) {
				if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
					Fox fox = new Fox(true);
					actors.add(fox);
					fox.setLocation(row, col);
					field.place(fox, row, col);
				}
				else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
					Rabbit rabbit = new Rabbit(true);
					actors.add(rabbit);
					rabbit.setLocation(row, col);
					field.place(rabbit, row, col);
				}
				else if(rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
					Hunter hunter = new Hunter();
					actors.add(hunter);
					hunter.setLocation(row, col);
					field.place(hunter, row, col);
				}
				// else leave the location empty.
			}
		}
		Collections.shuffle(actors, rand);
	}
}
