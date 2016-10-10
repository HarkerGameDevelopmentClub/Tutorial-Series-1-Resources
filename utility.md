#Utility file

This file contains several classes and methods that may be of use.

**Application:**<br/>
  static void launch(String[] args) <i> Call this method in the main(String[] args) method of your main class, then Eclipse can launch it like a normal class. </i><br/>
  abstract void start(Stage stage) <i> Your main class extending application needs to implement this method </i>

**Stage:**<br/>
  void setTitle(String title) <i> this is the title that appears in the bar at the top of the window </i> <br/>
  void setScene(Scene scene)<br/>
  void setHeight(double height)<br/>
  void setWidth(double width)<br/>
  void setResizable 
  void show() <i> Call this after setting up the stage to display it </i>
  
**Canvas:**<br/>
  void Canvas(double width, double height)<br/>
  GraphicsContext getGraphicsContext2D() <i> the graphics context has all of the drawing methods </i>
  
**GraphicsContext:**<br/>
  void drawImage(Image image, double x, double y) <i> draws an Image with its top left corner at the specified coordinates. </i><br/>
  void setFill(Color color) <i> Applies to *all* subsequent fills. </i> <br/>
  void fillText(String text, double x, double y) <i> Draw text with the specified fill color at the specified coordinates. </i> <br/>
  void clearRect(double x, double y, double width, double y) <i> Use it to erase the drawing of a previous frame at the start of the next frame. </i><br/>
  void drawRect(double x, double y, double width, double height) <i> draws a rectangle with the current fill color at the specified coordinates </i>
  
**Image:**<br/>
  void Image(String url) <i> The URL for an image in the src folder named spike.png would be "/spike.png". Note that creating an image from a url takes a lot of time, so if you are drawing the same image many times in a frame, you want to create it only once to prevent the game from lagging. </i>

**Group:**<br/>
  void Group(Node... nodes)

**Scene:**<br/>
  void Scene(Group group)<br/>
  void setOnKeyPressed(EventHandler<KeyEvent>)
  
**AnimationTimer:**<br/>
  void handle(long now)
  
**EventHandler<?> (interface):**<br/>
  void handle(KeyEvent event)
