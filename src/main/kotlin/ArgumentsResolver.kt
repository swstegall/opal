import java.io.File

object ArgumentsResolver {
  fun resolve(args: Array<String>) {
    if (args.isNotEmpty()) {
      when {
        args[0] == "generate" -> generate(args.drop(1).toTypedArray())
        args[0] == "--generate" -> generate(args.drop(1).toTypedArray())
        args[0] == "-g" -> generate(args.drop(1).toTypedArray())
        args[0] == "g" -> generate(args.drop(1).toTypedArray())
        args[0] == "help" -> printHelp()
        args[0] == "--help" -> printHelp()
        args[0] == "-h" -> printHelp()
        args[0] == "h" -> printHelp()
        args[0] == "version" -> printVersion()
        args[0] == "--version" -> printVersion()
        args[0] == "-v" -> printVersion()
        args[0] == "v" -> printVersion()
        else -> printHelp()
      }
    } else {
      printHelp()
    }
  }

  private fun generate(args: Array<String>) {
    if (args.isNotEmpty()) {
      when {
        args[0] == "package" -> generatePackage(args.drop(1).toTypedArray())
        args[0] == "--package" -> generatePackage(args.drop(1).toTypedArray())
        args[0] == "-pkg" -> generatePackage(args.drop(1).toTypedArray())
        args[0] == "pkg" -> generatePackage(args.drop(1).toTypedArray())
        else -> typeInvalidArguments("generate")
      }
    } else {
      optionInvalidArguments("generate")
    }
  }

  private fun generatePackage(args: Array<String>) {
    if (args.isNotEmpty()) {
      if (File(args[0]).mkdir()) {
        println("Package ${args[0]} created successfully.")
      } else {
        println("Package ${args[0]} already exists.")
      }
    } else {
      println("Package name not provided.")
    }
  }

  private fun optionInvalidArguments(option: String) {
    println("Invalid arguments for $option")
  }

  private fun typeInvalidArguments(option: String) {
    println("Invalid arguments for $option:type")
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
    println("\t\tproject\t (--project -p p)\tan Android project")
    println("\t\tkclass\t (--kclass -k k)\ta Kotlin class")
    println("\t\tkscript\t (--kscript -ks ks)\ta Kotlin script")
    println("\t\tsclass\t (--sclass -s s)\ta Scala class")
    println("\t\tclass\t (--class -c c)\t\ta Java class")
    println("\t\tgroovy\t (--groovy -gr gr)\ta Groovy script")
    println("\t\tpackage\t (--package -pkg pkg)\ta folder")
    println("\t\tresource (--resource -r r)\tan Android resource file")
    println("\t\tmanifest (--manifest -m m)\ta manifest file")
    println("\t\tgradle\t (--gradle -g g)\ta Gradle file")
    println("help\t(--help -h h)\t\t\t\tprints help information to the output stream")
    println("version\t(--version -v v)\t\t\tprints version information to the output stream")
  }
}