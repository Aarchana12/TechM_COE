import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart';

class ProfileScreen extends StatelessWidget {
  final String userId = "test_user"; // Hardcoded for now

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Profile"),
        backgroundColor: Colors.blueAccent,
        elevation: 0,
      ),
      body: Column(
        children: [
          // Profile Header
          Container(
            width: double.infinity,
            padding: EdgeInsets.symmetric(vertical: 40),
            decoration: BoxDecoration(
              gradient: LinearGradient(
                colors: [Colors.blueAccent, Colors.blue],
                begin: Alignment.topCenter,
                end: Alignment.bottomCenter,
              ),
            ),
            child: Column(
              children: [
                CircleAvatar(
                  radius: 55,
                  backgroundColor: Colors.white,
                  child: CircleAvatar(
                    radius: 50,
                    backgroundImage: NetworkImage(
                      'https://cdn1.iconfinder.com/data/icons/avatars-1-5/136/60-512.png',
                    ),
                  ),
                ),
                SizedBox(height: 10),
                Text(
                  "Aarchana Nichani",
                  style: TextStyle(
                    fontSize: 22,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
                Text(
                  "aarchananichani@email.com",
                  style: TextStyle(color: Colors.white70, fontSize: 14),
                ),
              ],
            ),
          ),

          SizedBox(height: 20),

          // Booking History Section
          Expanded(
            child: Padding(
              padding: EdgeInsets.symmetric(horizontal: 16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "Your Bookings",
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 10),

                  // Fetching Booking Details
                  Expanded(
                    child: StreamBuilder<QuerySnapshot>(
                      stream:
                          FirebaseFirestore.instance
                              .collection('bookings')
                              .where('userId', isEqualTo: userId)
                              .snapshots(),
                      builder: (context, snapshot) {
                        if (!snapshot.hasData) {
                          return Center(child: CircularProgressIndicator());
                        }

                        var bookings = snapshot.data!.docs;

                        if (bookings.isEmpty) {
                          return Center(child: Text("No bookings found"));
                        }

                        return ListView.builder(
                          itemCount: bookings.length,
                          itemBuilder: (context, index) {
                            var booking = bookings[index];
                            String formattedDate = DateFormat(
                              'dd MMM yyyy, hh:mm a',
                            ).format(
                              (booking['timestamp'] as Timestamp).toDate(),
                            );

                            return Card(
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(12),
                              ),
                              elevation: 4,
                              margin: EdgeInsets.symmetric(vertical: 8),
                              child: ListTile(
                                leading: Icon(
                                  Icons.build,
                                  color: Colors.blueAccent,
                                  size: 28,
                                ),
                                title: Text(
                                  booking['service'],
                                  style: TextStyle(
                                    fontSize: 16,
                                    fontWeight: FontWeight.w600,
                                  ),
                                ),
                                subtitle: Text(
                                  "Date: $formattedDate",
                                  style: TextStyle(fontSize: 14),
                                ),
                                trailing: Icon(
                                  Icons.check_circle,
                                  color: Colors.green,
                                  size: 28,
                                ),
                              ),
                            );
                          },
                        );
                      },
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
