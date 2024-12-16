module com.mycompany.tresenrayafuncionalmdpf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.tresenrayafuncionalmdpf to javafx.fxml;
    exports com.mycompany.tresenrayafuncionalmdpf;
}
