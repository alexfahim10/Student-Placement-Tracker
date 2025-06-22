import model.Placement;
import util.FileManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Placement> placements = FileManager.loadFromFile();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("📘 Welcome to Student Placement Tracker!");

        // 🔐 Password authentication
        if (!authenticateUser()) {
            return;
        }

        boolean running = true;

        while (running) {
            // ==== Main Menu ====
            System.out.println("\n==== MENU ====");
            System.out.println("1. Add Placement");
            System.out.println("2. View All Placements");
            System.out.println("3. Update Placement Status");
            System.out.println("4. Delete Placement");
            System.out.println("5. Search by Company");
            System.out.println("6. Exit (Save & Quit)");
            System.out.println("7. View Placement Statistics");
            System.out.println("8. Export to CSV");
            System.out.println("9. Filter Placements by Status");
            System.out.println("10. Generate Dummy Placements");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: addPlacement(); break;
                case 2: viewAllPlacements(); break;
                case 3: updateStatus(); break;
                case 4: deletePlacement(); break;
                case 5: searchByCompany(); break;
                case 6:
                    FileManager.saveToFile(placements);
                    System.out.println("💾 Data saved. Exiting... Goodbye!");
                    running = false;
                    break;
                case 7: showStats(); break;
                case 8: exportToCSV(); break;
                case 9: filterByStatus(); break;
                case 10: generateDummyData(); break;
                default: System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // 🔐 Authenticate before access
    public static boolean authenticateUser() {
        final String correctPassword = "admin123";
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("🔐 Enter admin password: ");
            String input = scanner.nextLine();
            if (input.equals(correctPassword)) {
                System.out.println("✅ Access granted. Welcome!");
                return true;
            } else {
                attempts++;
                System.out.println("❌ Incorrect password. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println("🔒 Too many failed attempts. Access denied.");
        return false;
    }

    // ➕ Add a placement
    public static void addPlacement() {
        System.out.println("\n--- Add Placement ---");
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();

        System.out.print("Enter job role: ");
        String role = scanner.nextLine();

        double pkg = 0;
        while (true) {
            try {
                System.out.print("Enter package offered (in LPA): ");
                pkg = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }

        System.out.print("Enter interview date (dd-mm-yyyy): ");
        String date = scanner.nextLine();

        System.out.print("Enter status (Applied/Selected/Rejected): ");
        String status = scanner.nextLine();

        placements.add(new Placement(company, role, pkg, status, date));
        System.out.println("✅ Placement added successfully!");
    }

    // 📄 View all placements
    public static void viewAllPlacements() {
        System.out.println("\n--- All Placements ---");

        if (placements.isEmpty()) {
            System.out.println("⚠️ No placements available.");
            return;
        }

        System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", "Company", "Role", "Package", "Interview Date", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (Placement p : placements) {
            System.out.printf("%-20s %-15s %-10.2f %-15s %-15s%n",
                    p.getCompany(), p.getRole(), p.getPackageOffered(), p.getInterviewDate(), p.getStatus());
        }
    }

    // ✏️ Update placement status
    public static void updateStatus() {
        System.out.println("\n--- Update Placement Status ---");
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();

        boolean found = false;
        for (Placement p : placements) {
            if (p.getCompany().equalsIgnoreCase(company)) {
                System.out.print("Enter new status: ");
                p.setStatus(scanner.nextLine());
                System.out.println("✅ Status updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("⚠️ Placement not found.");
        }
    }

    // ❌ Delete placement
    public static void deletePlacement() {
        System.out.println("\n--- Delete Placement ---");
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();

        boolean removed = placements.removeIf(p -> p.getCompany().equalsIgnoreCase(company));
        if (removed) {
            System.out.println("🗑️ Placement deleted.");
        } else {
            System.out.println("⚠️ Placement not found.");
        }
    }

    // 🔍 Search placements
    public static void searchByCompany() {
        System.out.println("\n--- Search by Company ---");
        System.out.print("Enter company name: ");
        String name = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", "Company", "Role", "Package", "Interview Date", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (Placement p : placements) {
            if (p.getCompany().toLowerCase().contains(name)) {
                System.out.printf("%-20s %-15s %-10.2f %-15s %-15s%n",
                        p.getCompany(), p.getRole(), p.getPackageOffered(), p.getInterviewDate(), p.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠️ No matches found.");
        }
    }

    // 📊 Show placement stats
    public static void showStats() {
        System.out.println("\n📊 --- Statistics ---");

        int total = placements.size(), selected = 0, rejected = 0, applied = 0;
        double totalPackage = 0;
        for (Placement p : placements) {
            String status = p.getStatus().toLowerCase();
            switch (status) {
                case "selected" -> {
                    selected++;
                    totalPackage += p.getPackageOffered();
                }
                case "rejected" -> rejected++;
                case "applied" -> applied++;
            }
        }

        System.out.println("Total Placements: " + total);
        System.out.println("✅ Selected: " + selected);
        System.out.println("❌ Rejected: " + rejected);
        System.out.println("⏳ Applied: " + applied);
        if (selected > 0) {
            System.out.printf("💰 Avg. Package (Selected): %.2f LPA%n", totalPackage / selected);
        } else {
            System.out.println("💰 Avg. Package (Selected): N/A");
        }
    }

    // 📤 Export data to CSV
    public static void exportToCSV() {
        System.out.println("\n📤 Exporting to placements.csv...");
        try (PrintWriter writer = new PrintWriter("placements.csv")) {
            writer.println("Company,Role,Package,Interview Date,Status");
            for (Placement p : placements) {
                writer.printf("%s,%s,%.2f,%s,%s%n",
                        p.getCompany(), p.getRole(), p.getPackageOffered(), p.getInterviewDate(), p.getStatus());
            }
            System.out.println("✅ Exported successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // 📌 Filter placements by status
    public static void filterByStatus() {
        System.out.println("\n🔍 Filter by Status");
        System.out.print("Enter status (Applied/Selected/Rejected): ");
        String status = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.printf("%-20s %-15s %-10s %-15s %-15s%n", "Company", "Role", "Package", "Interview Date", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (Placement p : placements) {
            if (p.getStatus().toLowerCase().equals(status)) {
                System.out.printf("%-20s %-15s %-10.2f %-15s %-15s%n",
                        p.getCompany(), p.getRole(), p.getPackageOffered(), p.getInterviewDate(), p.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("⚠️ No placements found with that status.");
        }
    }

    // 🧪 Generate dummy data
    public static void generateDummyData() {
        System.out.println("\n🧪 Adding 10 dummy placements...");

        placements.add(new Placement("Google", "SDE", 12.5, "Selected", "10-07-2025"));
        placements.add(new Placement("Amazon", "Backend Dev", 10.0, "Applied", "18-07-2025"));
        placements.add(new Placement("Infosys", "System Engineer", 4.0, "Rejected", "05-07-2025"));
        placements.add(new Placement("TCS", "Support", 3.6, "Applied", "22-07-2025"));
        placements.add(new Placement("Flipkart", "Frontend Dev", 9.2, "Selected", "30-07-2025"));
        placements.add(new Placement("Accenture", "Consultant", 6.0, "Selected", "02-08-2025"));
        placements.add(new Placement("Wipro", "Java Developer", 5.5, "Rejected", "12-07-2025"));
        placements.add(new Placement("Cognizant", "Test Engineer", 3.8, "Applied", "15-07-2025"));
        placements.add(new Placement("Paytm", "Android Dev", 8.5, "Selected", "28-07-2025"));
        placements.add(new Placement("Capgemini", "DevOps", 5.0, "Rejected", "20-07-2025"));

        System.out.println("✅ Dummy placements added!");
    }
}
