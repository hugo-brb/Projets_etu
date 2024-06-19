module org.example.chiefs_arena {
	requires com.google.gson;
	requires javafx.controls;
	requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;
	requires java.desktop;

    exports org.example.chiefs_arena.user to javafx.fxml;
    exports org.example.chiefs_arena;
    exports org.example.chiefs_arena.App;
    opens org.example.chiefs_arena.App to javafx.fxml, com.google.gson;
	opens org.example.chiefs_arena.user to com.google.gson;
    opens org.example.chiefs_arena to com.google.gson, javafx.fxml;


}