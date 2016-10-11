#Utility file

This file contains several classes and methods that may be of use.

**Application:**<br/>
  static void launch(String[] args) <i> Launches the game. Call this method in the main method of your main class. </i><br/>
  abstract void start(Stage stage) <i> Called by launch. Initialize variables and set up your game in this method. </i>

**Stage:**<br/>
  void setTitle(String title) <i> This is the title that appears in the bar at the top of the window. </i> <br/>
  void setScene(Scene scene)<br/>
  void setHeight(double height)<br/>
  void setWidth(double width)<br/>
  void setResizable(boolean resizable)<br/>
  void show() <i> Call this after setting up the stage to display it. </i>
  
**Canvas:**<br/>
  void Canvas(double width, double height)<br/>
  GraphicsContext getGraphicsContext2D()
  
**GraphicsContext:**<br/>
  void drawImage(Image image, double x, double y) <i> Draws an Image with its top left corner at the specified coordinates. </i><br/>
  void setFill(Color color) <i> Applies to *all* subsequent fills. </i> <br/>
  void fillText(String text, double x, double y) <i> Draw text with the specified fill color at the specified coordinates. </i> <br/>
  void clearRect(double x, double y, double width, double y) <i> Erases the specified rectangle. </i><br/>
  void drawRect(double x, double y, double width, double height) <i> Draws a rectangle with the current fill color at the specified coordinates </i>
  
**Image:**<br/>
  void Image(String url) <i> The URL for an image in the src folder named spike.png would be "/spike.png". Note that loading an image from a url takes a lot of time, so if you are drawing the same image many times in a frame, you want to load it only once and reuse the Image object to prevent the game from lagging. </i>

**Group:**<br/>
  void Group(Node... nodes)

**Scene:**<br/>
  void Scene(Group group)<br/>
  void setOnKeyPressed(EventHandler<KeyEvent>)
  
**AnimationTimer:**<br/>
  void handle(long now)
  
**EventHandler<?> (interface):**<br/>
  void handle(KeyEvent event)
