#Utility file

This file contains several classes and methods that may be of use.

**Application:**<br/>
  static void launch(String[] args)<br/>
  abstract void start(Stage stage)

**Stage:**<br/>
  void setTitle(String title)<br/>
  void setScene(Scene scene)<br/>
  void setHeight(double height)<br/>
  void setWidth(double width)<br/>
  void show()
  
**Canvas:**<br/>
  void Canvas(double width, double height)<br/>
  GraphicsContext getGraphicsContext2D()
  
**GraphicsContext:**<br/>
  void drawImage(Image image, double x, double y)<br/>
  void setFill(Color color)<br/>
  void fillText(String text, double x, double y)<br/>
  void clearRect(double x, double y, double width, double y)<br/>
  void drawRect(double x, double y, double width, double height)
  
**Image:**<br/>
  void Image(String url)

**Group:**<br/>
  void Group(Node... nodes)

**Scene:**<br/>
  void Scene(Group group)<br/>
  void setOnKeyPressed(EventHandler<KeyEvent>)
  
**AnimationTimer:**<br/>
  void handle(long now)
  
**EventHandler<?> (interface):**<br/>
  void handle(KeyEvent event)
