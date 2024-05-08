-- Insert initial users
INSERT INTO users (user_id, username, email, password) VALUES
('11111111-1111-1111-1111-111111111111', 'user1', 'user1@example.com', 'password1'),
('22222222-2222-2222-2222-222222222222', 'user2', 'user2@example.com', 'password2');

-- Insert initial events
INSERT INTO events (event_id, name, venue, date, tickets_available, ticket_price) VALUES
('33333333-3333-3333-3333-333333333333', 'Event 1', 'Venue 1', '2024-05-01', 100, 20.00),
('44444444-4444-4444-4444-444444444444', 'Event 2', 'Venue 2', '2024-05-10', 50, 25.00);
