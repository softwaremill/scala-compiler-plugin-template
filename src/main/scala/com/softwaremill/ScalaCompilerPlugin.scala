package com.softwaremill

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}

class ScalaCompilerPlugin(override val global: Global) extends Plugin {

  override val name: String = "scala-compiler-plugin"
  override val description: String = "scala compiler plugin simple example"

  override val components: List[PluginComponent] = List(new ScalaCompilerPluginComponent(global))
}

class ScalaCompilerPluginComponent(val global: Global) extends PluginComponent {
  override val phaseName: String = "compiler-plugin-phase"
  override val runsAfter: List[String] = List("parser")

  override def newPhase(prev: Phase): Phase = new StdPhase(prev) {
    override def apply(unit: global.CompilationUnit): Unit = {
      global.reporter.echo("implement me ")
    }
  }
}
