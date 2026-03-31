import java.util.Stack;
// Model Class (DLL Node)
class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;
    HistoryNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}
// Browser Tab with browsing history
class BrowserTab {
    private HistoryNode head;
    private HistoryNode current;
    // Visit a new website
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        System.out.println("Visited: " + url);
    }
    // Go back
    public void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }
    // Go forward
    public void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page.");
        }
    }
    // Print browsing history
    public void showHistory() {
        HistoryNode temp = head;
        System.out.print("History: ");
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.url + "] ");
            } else {
                System.out.print(temp.url + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
// Tab Manager to handle multiple tabs
class TabManager {
    private BrowserTab currentTab;
    private Stack<BrowserTab> closedTabs;
    public TabManager() {
        currentTab = new BrowserTab();
        closedTabs = new Stack<>();
    }
    public BrowserTab getTab() {
        return currentTab;
    }
    // Close tab
    public void closeTab() {
        closedTabs.push(currentTab);
        currentTab = new BrowserTab();
        System.out.println("Tab closed.");
    }
    // Restore last closed tab
    public void restoreTab() {
        if (!closedTabs.isEmpty()) {
            currentTab = closedTabs.pop();
            System.out.println("Tab restored.");
        } else {
            System.out.println("No tabs to restore.");
        }
    }
}
// Main class
public class BrowserBuddyApp {
    public static void main(String[] args) {
        TabManager manager = new TabManager();
        BrowserTab tab = manager.getTab();
        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("leetcode.com");
        tab.showHistory();
        tab.back();
        tab.back();
        tab.showHistory();
        tab.forward();
        tab.showHistory();
        manager.closeTab();
        manager.restoreTab();
        tab = manager.getTab();
        tab.showHistory();
    }
}
