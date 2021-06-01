
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import java.nio.file.Files
import java.nio.file.Paths

class Graph : Application() {
    override fun start(primaryStage: Stage?) {

        primaryStage?.title = "Graph"

//        val polygon = Polygon()
//        val reader = Files.newBufferedReader(Paths.get("/Users/tryagain/Desktop/busStop77_coordinates.txt"))
//        var x = reader.readLine()
//        var y: String?
        val nodes = mutableListOf<Node>()

//        while (x != null) {
//            y = reader.readLine()
//            val rectangle = Rectangle(7.0 , 7.0, Color.RED)
//            val xOnMap = (((x.toDouble() - 55.7) * 39) * 1000) - 400
//            val yOnMap = ((((y.toDouble() - 37.4) * 10) * 1000) - 300)
//            rectangle.x = xOnMap
//            rectangle.y = yOnMap
//            nodes.add(rectangle)
//            x = reader.readLine()
//        }

        val homeReader = Files.newBufferedReader(Paths.get("/Users/tryagain/Desktop/test1.txt"))
//
        var xHome = homeReader.readLine()
        var yHome: String?

        while (xHome != null) {
            yHome = homeReader.readLine()
            val xOnMap = ((((xHome.toDouble() * 1000) % 1000) % 100) * 30)
            val yOnMap = ((((yHome.toDouble() * 1000) % 1000) % 100) * 10) - 300
            val homeRectangle = Rectangle(7.0, 7.0, Color.BLUE)
            homeRectangle.x = xOnMap
            homeRectangle.y = yOnMap
            println(xHome)
            println(yHome)
            println(xOnMap)
            println(yOnMap)
            nodes.add(homeRectangle)
            xHome = homeReader.readLine()
        }

        val myScene = Scene(Group(nodes), 1500.0, 1200.0)
        primaryStage?.scene = myScene
        primaryStage?.show()
    }

    fun s() {
        launch()
    }
}
