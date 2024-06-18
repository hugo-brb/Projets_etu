module org.example.chiefs_arena {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens org.example.chiefs_arena to javafx.fxml;
    exports org.example.chiefs_arena;
    opens com.example.chiefarena to javafx.fxml;
    exports org.example.chiefs_arena.Controller;
    opens org.example.chiefs_arena.Controller to javafx.fxml;
    exports org.example.chiefs_arena.App;
    opens org.example.chiefs_arena.App to javafx.fxml;
}