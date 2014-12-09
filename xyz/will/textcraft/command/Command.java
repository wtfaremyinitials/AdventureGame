package xyz.will.textcraft.command;import xyz.will.textcraft.Game;import xyz.will.textcraft.World;import xyz.will.textcraft.entity.Player;/** * Class Command - Part of the game. *  * author:  Will Franzen * version: 1.0 * date:    Dec 2014 * * This is a generic abstract Command class, which acts a superclass to all other commands. * It provides instances of the game, player, and world to the other commands. */public abstract class Command{    protected String argument;    public Game game;    public Player player;    public World world;    /**     * Create a command object. The argument can be passed null if the user did not provide one.     */    public Command(String argument)    {        this.argument = argument;        this.game = Game.getInstance();        this.player = game.getPlayer();        this.world = game.getWorld();    }    /**     * Return the second word of this command. Returns null if there was no     * second word.     */    public String getArgument()    {        return argument;    }    /**     * Return true if the command has a second word.     */    public boolean hasArgument()    {        return argument != null;    }        /**     * Method called when the command is ready to be executed     */    public abstract void run();}