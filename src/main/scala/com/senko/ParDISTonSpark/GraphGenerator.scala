package com.senko.ParDISTonSpark

import org.apache.log4j.{LogManager, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.graphx.{Edge, Graph}

object GraphGenerator {

  var log: Logger = LogManager.getLogger(GraphGenerator.getClass)

  def createParDistExampleGraph: (Seq[(Long, Node)], Seq[Edge[Int]]) = {
    val vertexN0 = (1L, Node("n0", isBorderNode = false, "C1", None))
    val vertexN1 = (2L, Node("n1", isBorderNode = false, "C1", None))
    val vertexN2 = (3L, Node("n2", isBorderNode = true, "C1", None))
    val vertexN3 = (4L, Node("n3", isBorderNode = true, "C1", None))
    val vertexN4 = (5L, Node("n4", isBorderNode = true, "C1", None))
    val vertexN5 = (6L, Node("n5", isBorderNode = false, "C1", None))

    val vertexN6 = (7L, Node("n6", isBorderNode = true, "C2", None))
    val vertexN7 = (8L, Node("n7", isBorderNode = true, "C2", None))
    val vertexN9 = (9L, Node("n9", isBorderNode = false, "C2", None))
    val vertexN11 = (10L, Node("n11", isBorderNode = false, "C2", None))
    val vertexN12 = (11L, Node("n12", isBorderNode = true, "C2", None))

    val vertexN16 = (12L, Node("n16", isBorderNode = true, "C3", None))
    val vertexN20 = (13L, Node("n20", isBorderNode = false, "C3", None))
    val vertexN15 = (14L, Node("n15", isBorderNode = false, "C3", None))
    val vertexN19 = (15L, Node("n19", isBorderNode = true, "C3", None))
    val vertexN14 = (16L, Node("n14", isBorderNode = false, "C3", None))

    val vertexN18 = (17L, Node("n18", isBorderNode = true, "C4", None))
    val vertexN17 = (18L, Node("n17", isBorderNode = false, "C4", None))
    val vertexN13 = (19L, Node("n13", isBorderNode = false, "C4", None))
    val vertexN10 = (20L, Node("n10", isBorderNode = false, "C4", None))
    val vertexN8 = (21L, Node("n8", isBorderNode = true, "C4", None))

    val seqOfVertices: Seq[(Long, Node)] = Seq(
      vertexN0, vertexN1, vertexN2, vertexN3, vertexN4, vertexN5, vertexN6,
      vertexN7, vertexN8, vertexN9, vertexN10, vertexN11, vertexN12, vertexN13,
      vertexN14, vertexN15, vertexN16, vertexN17, vertexN18, vertexN19, vertexN20
    )

    val seqOfEdges: Seq[Edge[Int]] = Seq(
      Edge(vertexN0._1, vertexN1._1, 4), Edge(vertexN1._1, vertexN0._1, 4),
      Edge(vertexN0._1, vertexN4._1, 4), Edge(vertexN4._1, vertexN0._1, 4),
      Edge(vertexN0._1, vertexN5._1, 4), Edge(vertexN5._1, vertexN0._1, 4),
      Edge(vertexN4._1, vertexN5._1, 3), Edge(vertexN5._1, vertexN4._1, 3),
      Edge(vertexN5._1, vertexN2._1, 3), Edge(vertexN2._1, vertexN5._1, 3),
      Edge(vertexN1._1, vertexN2._1, 2), Edge(vertexN2._1, vertexN1._1, 2),
      Edge(vertexN1._1, vertexN3._1, 8), Edge(vertexN3._1, vertexN1._1, 8),
      Edge(vertexN2._1, vertexN3._1, 7), Edge(vertexN3._1, vertexN2._1, 7),

      Edge(vertexN2._1, vertexN6._1, 2), Edge(vertexN6._1, vertexN2._1, 2),
      Edge(vertexN3._1, vertexN7._1, 2), Edge(vertexN7._1, vertexN3._1, 2),

      Edge(vertexN6._1, vertexN7._1, 2), Edge(vertexN7._1, vertexN6._1, 2),
      Edge(vertexN7._1, vertexN12._1, 5), Edge(vertexN12._1, vertexN7._1, 5),
      Edge(vertexN6._1, vertexN9._1, 3), Edge(vertexN9._1, vertexN6._1, 3),
      Edge(vertexN9._1, vertexN11._1, 3), Edge(vertexN11._1, vertexN9._1, 3),
      Edge(vertexN6._1, vertexN11._1, 6), Edge(vertexN11._1, vertexN6._1, 6),
      Edge(vertexN11._1, vertexN12._1, 2), Edge(vertexN12._1, vertexN11._1, 2),

      Edge(vertexN12._1, vertexN16._1, 4), Edge(vertexN16._1, vertexN12._1, 4),

      Edge(vertexN16._1, vertexN15._1, 2), Edge(vertexN15._1, vertexN16._1, 2),
      Edge(vertexN16._1, vertexN20._1, 5), Edge(vertexN20._1, vertexN16._1, 5),
      Edge(vertexN20._1, vertexN15._1, 5), Edge(vertexN15._1, vertexN20._1, 5),
      Edge(vertexN15._1, vertexN14._1, 2), Edge(vertexN14._1, vertexN15._1, 2),
      Edge(vertexN15._1, vertexN19._1, 5), Edge(vertexN19._1, vertexN15._1, 5),
      Edge(vertexN14._1, vertexN19._1, 4), Edge(vertexN19._1, vertexN14._1, 4),

      Edge(vertexN19._1, vertexN18._1, 2), Edge(vertexN18._1, vertexN19._1, 2),

      Edge(vertexN18._1, vertexN17._1, 3), Edge(vertexN17._1, vertexN18._1, 3),
      Edge(vertexN18._1, vertexN13._1, 6), Edge(vertexN13._1, vertexN18._1, 6),
      Edge(vertexN18._1, vertexN10._1, 7), Edge(vertexN10._1, vertexN18._1, 7),
      Edge(vertexN10._1, vertexN8._1, 3), Edge(vertexN8._1, vertexN10._1, 3),
      Edge(vertexN17._1, vertexN13._1, 4), Edge(vertexN13._1, vertexN17._1, 4),
      Edge(vertexN13._1, vertexN10._1, 4), Edge(vertexN10._1, vertexN13._1, 4),
      Edge(vertexN13._1, vertexN8._1, 5), Edge(vertexN8._1, vertexN13._1, 5),

      Edge(vertexN8._1, vertexN4._1, 3), Edge(vertexN4._1, vertexN8._1, 3)
    )

    (seqOfVertices, seqOfEdges)


  }

  def createDirectedSampleGraph: (Seq[(Long, Node)], Seq[Edge[Int]]) = {
    val vertexA = (1L, Node("A", isBorderNode = false, "C1", None))
    val vertexB = (2L, Node("B", isBorderNode = true, "C1", None))
    val vertexC = (3L, Node("C", isBorderNode = true, "C1", None))
    val vertexD = (4L, Node("D", isBorderNode = true, "C2", None))
    val vertexE = (5L, Node("E", isBorderNode = false, "C2", None))

    val seqOfVertices = Seq(vertexA, vertexB, vertexC, vertexD, vertexE)

    val seqOfEdges = Seq(
      Edge(vertexA._1, vertexB._1, 2),
      Edge(vertexB._1, vertexC._1, 10), Edge(vertexC._1, vertexB._1, 8),
      Edge(vertexB._1, vertexD._1, 3),
      Edge(vertexC._1, vertexD._1, 2),
      Edge(vertexD._1, vertexE._1, 4),
      Edge(vertexD._1, vertexB._1, 1)
    )

    (seqOfVertices, seqOfEdges)
  }

  def createGraph(sc: SparkContext): Graph[Node, Int] = {
    log.info("Creating Graph... for ParDIST paper example")

    val (vertices, edges) = createParDistExampleGraph
    //val (vertices, edges) = createDirectedSampleGraph

    log.info("vertices and edges parallelizing")
    val verticesRDD = sc.parallelize(vertices)
    val edgesRDD = sc.parallelize(edges)

    val graph = Graph(verticesRDD, edgesRDD)

    log.info("returning graph")
    graph

  }

}
