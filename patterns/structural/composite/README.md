# Composite Design Pattern

It's a type of structural design pattern that let us treat a single object and group of objects in the same way.

## Code

```java
package file;

public interface FileSystemItem {
    int getSize();
    void printStructure(String indent);
    void delete();
}

package file;

/**
 * Leaf
 */
public class File implements FileSystemItem{
    private final int size;
    private final String name;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "- " + name + " (" + size + " KB)");
    }

    @Override
    public void delete() {
        System.out.println("File Deleted: " + name);
    }
}

package file;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite
 */
public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addItem(FileSystemItem item) {
        this.children.add(item);
    }

    @Override
    public int getSize() {
        int total = 0;
        for (FileSystemItem item : children) {
            total += item.getSize();
        }
        return total;
    }

    @Override
    public void printStructure(String indent) {
        System.out.println(indent + "+ " + name + "/");
        for (FileSystemItem item : children) {
            item.printStructure(indent + "  ");
        }
    }

    @Override
    public void delete() {
        for (FileSystemItem item : children) {
            item.delete();
        }
    }
}

import file.File;
import file.FileSystemItem;
import file.Folder;

/**
 * Client Application
 */
public class Application {
    public static void main(String[] args) {
        FileSystemItem file1 = new File("profile.jpg", 200);
        FileSystemItem file2 = new File("notes.txt", 500);

        Folder documents = new Folder("Documents");
        documents.addItem(file1);
        documents.addItem(file2);

        // print structure
        documents.printStructure("");

        // get total size
        System.out.println("total size: " + documents.getSize());
    }
}

```