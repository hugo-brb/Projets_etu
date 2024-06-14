module org.example.chiefs_arena {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.chiefs_arena to javafx.fxml;
    exports org.example.chiefs_arena;
}