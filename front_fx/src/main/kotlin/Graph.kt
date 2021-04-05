
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.FlowPane
import javafx.scene.paint.Color
import javafx.scene.shape.Polygon
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import java.nio.file.Files
import java.nio.file.Paths

class Graph : Application() {
    override fun start(primaryStage: Stage?) {

        primaryStage?.title = "Graph"
        val root = FlowPane()
        val polygon = Polygon()
        val reader = Files.newBufferedReader(Paths.get("/Users/tryagain/Desktop/bus_stops_coordinates.txt"))
        var x = reader.readLine()
        var y: String? = null
        val nodes = mutableListOf<Node>()

        while (x != null) {
            y = reader.readLine()
            val rectangle = Rectangle(7.0 , 7.0, Color.RED)
            rectangle.x = (((x.toDouble() - 55.7) * 7 ) * 1000) + 500
            rectangle.y = (((y.toDouble() - 37.4) * 7 ) * 1000)
            nodes.add(rectangle)
            x = reader.readLine()
        }

        val homeReader = Files.newBufferedReader(Paths.get("/Users/tryagain/Desktop/homes_coordinates.txt"))

        var xHome = homeReader.readLine()
        var yHome: String? = null

//        while (xHome != null) {
//            yHome = homeReader.readLine()
//            val homeRectangle = Rectangle(5.0, 5.0, Color.BLUE)
//            homeRectangle.x = (((xHome.toDouble() - 55.7) * 2) * 1000)
//            homeRectangle.y = (((yHome.toDouble() - 37.4) * 2) * 1000)
//            println(homeRectangle.x)
//            println(homeRectangle.y)
//            nodes.add(homeRectangle)
//            xHome = homeReader.readLine()
//        }
        polygon.stroke = Color.BLUE
        polygon.fill = Color.BLUE
        val myScene = Scene(Group(nodes), 1500.0, 1200.0)
        primaryStage?.scene = myScene
        primaryStage?.show()

    }

    fun s() {
        launch()
    }
}