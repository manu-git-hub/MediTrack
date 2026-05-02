# Environment Setup & Configuration

To successfully run the MediTrack application, we must first configure our Java development environment by installing
the Java Development Kit (JDK)[cite: 1].

## 1. Download and Install the JDK

### For Windows:

1. Navigate to the official Oracle website or an OpenJDK provider (like Adoptium).
2. Download the latest Long-Term Support (LTS) JDK `.exe` or `.msi` installer.
3. Run the installer and complete the setup process, noting the directory where Java is installed (e.g.,
   `C:\Program Files\Java\jdk-17`).

### For macOS:

We can install the JDK manually or via Homebrew (recommended).
**Using Homebrew (Terminal):**

1. Open Terminal.
2. Run the following command: `brew install openjdk@17` (or the desired LTS version).
   **Manual Installation:**
1. Download the macOS `.dmg` installer from Oracle or Adoptium.
2. Open the downloaded file and follow the installation wizard.

## 2. Configure Environment Variables

To ensure we can compile and run Java from any terminal window, we need to set our system's environment variables.

### Windows Configuration:

1. Open the Windows Start Menu, search for "Environment Variables", and select "Edit the system environment variables".
2. **Create JAVA_HOME:** Under "System variables", click "New".
    * Variable name: `JAVA_HOME`
    * Variable value: *[Path to the JDK installation directory, e.g., C:\Program Files\Java\jdk-17]*
    * *(Please insert a screenshot of the Windows JAVA_HOME setup here)*
3. **Update Path:** Find the `Path` variable in the list, click "Edit", and add a new entry: `%JAVA_HOME%\bin`.
    * *(Please insert a screenshot of the Windows Path setup here)*

### macOS Configuration:

macOS often sets up the path automatically, but defining `JAVA_HOME` explicitly is standard practice for Java
development.

1. Open Terminal.
2. Determine where Java is installed by running: `/usr/libexec/java_home`
3. Open the shell configuration file. If using macOS Catalina or newer, the default shell is Zsh:
   ```bash
   nano ~/.zshrc

## 3. Verify Installation

Open a new Command Prompt or Terminal and execute the following commands to confirm our setup:

```bash
# Check the Java Runtime Environment
java -version

# Check the Java Compiler
javac -version