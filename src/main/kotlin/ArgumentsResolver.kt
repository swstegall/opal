object ArgumentsResolver {
  fun resolve(args: Array<String>) {
    if (args.isNotEmpty()) {
      when {
        args[0] == "generate" -> generate(args.drop(1).toTypedArray())
        args[0] == "help" -> printHelp()
        args[0] == "--help" -> printHelp()
        args[0] == "-h" -> printHelp()
        args[0] == "version" -> printVersion()
        args[0] == "--version" -> printVersion()
        args[0] == "-v" -> printVersion()
        else -> printHelp()
      }
    } else {
      printHelp()
    }
  }

  private fun generate(args: Array<String>) {
    if (args.isNotEmpty()) {
      println("Remaining arguments:")
      for (arg in args) {
        print(arg)
      }
      println()
    } else {
      optionInvalidArguments("generate")
    }
  }

  private fun optionInvalidArguments(option: String) {
    println("Invalid arguments for $option")
  }

  private fun printVersion() {
    println("opal 0.0.1")
  }

  private fun printHelp() {
    println("Usage: opal [options]")
    println()
    println("where options include:")
    println()
    println("generate (--generate -g g) [types] <name>\tgenerates a skeleton of a supported opal template type with a specified name")
    println("\twhere types include:")
    println("\t\tproject\t (--project -p p)\t\t\tan Android project")
    println("\t\tkclass\t (--kclass -k k)\t\t\ta Kotlin class")
    println("\t\tkscript\t (--kscript -ks ks)\t\ta Kotlin script")
    println("\t\tsclass\t (--sclass -s s)\t\t\ta Scala class")
    println("\t\tclass\t\t (--class -c c)\t\t\t\ta Java class")
    println("\t\tgroovy\t (--groovy -gr gr)\t\ta Groovy script")
    println("\t\tpackage\t (--package -pkg pkg)\ta folder")
    println("\t\tresource (--resource -r r)\t\tan Android resource file")
    println("\t\tmanifest (--manifest -m m)\t\ta manifest file")
    println("\t\tgradle\t (--gradle -g g)\t\t\ta Gradle file")
    println("help\t\t (--help -h h)\t\t\t\t\t\t\t\t\t\tprints help information to the output stream")
    println("version\t (--version -v v) \t\t\t\t\t\t\t\tprints version information to the output stream")
  }
}