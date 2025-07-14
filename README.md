
---

One of my core Java projects is called **File Security Manager**. It’s a simple yet practical tool that I built to **secure the contents of a text file** by converting it into an unreadable format, and then **recover it back** when needed using the same key and algorithm.

The idea was to understand **file handling, custom logic**, and **basic encryption** concepts in Java.

Here’s how it works:

1. First, the system asks the user to **enter the name of an existing `.txt` file**. It checks if the file is actually present or not — using Java File I/O validation.

2. Then, the user provides a **security number** or key, and the application applies a **custom algorithm** to **encrypt** the file — basically converting readable text into some scrambled format and saving it as a new file.

3. To unlock the file back into its original form, the user has to **enter the correct key**. If the key or input doesn't match the one used earlier, the program throws a **custom exception**, saying access is denied or the key is invalid.

4. Similarly, if someone tries to decrypt without knowing the correct logic or enters wrong inputs, the application handles that using Java’s **exception handling** mechanism.

---

### 🧠 What I Learned:

* It really helped me improve my understanding of:

  * **Java File I/O**
  * **BufferedReader, FileWriter, InputStreams**
  * Creating and using **custom exceptions**
  * Structuring code to securely **encode/decode** information
* Most importantly, it gave me confidence in writing **user-driven Java applications** with proper input validation and modular design.

---

