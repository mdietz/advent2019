import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.google.common.collect.ImmutableList;

class IntcodeProgram {

  private final String filename;
  private ImmutableList<String> intcodes;

  public IntcodeProgram(String filename) throws FileNotFoundException {
    this.filename = filename;
    parseProgram();
  }

  private final void parseProgram() throws FileNotFoundException {
    File file = new File(filename);
      Scanner scanner = new Scanner(file);
    if (scanner.hasNext()) {
      String line = scanner.next();
      this.intcodes = ImmutableList.copyOf(line.split(","));
    }
    scanner.close();
  }

  public final void prettyPrint() {
    int printNextN = 0;
    int count = 0;
    for (String elem : this.intcodes) {
      count++;
      if (printNextN == 1) {
        System.out.println(", " + elem);
        printNextN = 0;
        continue;
      } 
      if (printNextN > 1) {
        System.out.print(", " + elem);
        printNextN -= 1;
        continue;
      }
      if (elem.equals("99")) {
        System.out.println(elem);
      } else if (elem.equals("1") || elem.equals("2")) {
        System.out.print(elem);
        printNextN = 3;
      } else {
        System.out.print(elem);
        printNextN = this.intcodes.size() - count + 1;
      }
    }
  }
}