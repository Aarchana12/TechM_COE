import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class BookingScreen extends StatefulWidget {
  @override
  _BookingScreenState createState() => _BookingScreenState();
}

class _BookingScreenState extends State<BookingScreen> {
  final TextEditingController nameController = TextEditingController();
  final TextEditingController phoneController = TextEditingController();
  final TextEditingController addressController = TextEditingController();
  String? selectedService;

  final List<String> services = [
    "Plumber",
    "Electrician",
    "Carpenter",
    "Painter",
  ];

  Future<void> bookService() async {
    if (nameController.text.isEmpty ||
        phoneController.text.isEmpty ||
        addressController.text.isEmpty ||
        selectedService == null) {
      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text("Please fill all fields!")));
      return;
    }

    try {
      await FirebaseFirestore.instance.collection('bookings').add({
        'userId': "test_user", // Hardcoded user ID
        'name': nameController.text,
        'phone': phoneController.text,
        'service': selectedService,
        'address': addressController.text,
        'timestamp': Timestamp.now(),
      });

      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text("Booking successful!")));

      Navigator.pop(context); // Go back to the previous screen
    } catch (e) {
      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text("Error booking service: $e")));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Book a Service")),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            TextField(
              controller: nameController,
              decoration: InputDecoration(labelText: "Your Name"),
            ),
            SizedBox(height: 10),
            TextField(
              controller: phoneController,
              decoration: InputDecoration(labelText: "Phone Number"),
              keyboardType: TextInputType.phone,
            ),
            SizedBox(height: 10),
            DropdownButtonFormField<String>(
              value: selectedService,
              decoration: InputDecoration(labelText: "Select Service"),
              items:
                  services.map((service) {
                    return DropdownMenuItem(
                      value: service,
                      child: Text(service),
                    );
                  }).toList(),
              onChanged: (value) {
                setState(() {
                  selectedService = value;
                });
              },
            ),
            SizedBox(height: 10),
            TextField(
              controller: addressController,
              decoration: InputDecoration(labelText: "Address"),
            ),
            SizedBox(height: 20),
            ElevatedButton(onPressed: bookService, child: Text("Book Now")),
          ],
        ),
      ),
    );
  }
}
