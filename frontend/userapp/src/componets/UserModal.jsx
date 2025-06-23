import { Modal, Button } from "react-bootstrap";

function UserModal({ show, onClose, user }) {
  if (!user) return null;

  return (
    <Modal show={show} onHide={onClose}>
      <Modal.Header closeButton>
        <Modal.Title>{user.firstName} {user.lastName}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <img src={user.image} alt="User" className="img-fluid mb-3" />
        <p><strong>ID:</strong> {user.id}</p>
        <p><strong>Email:</strong> {user.email}</p>
        <p><strong>Phone:</strong> {user.phone}</p>
        <p><strong>Age:</strong> {user.age}</p>
        <p><strong>Company:</strong> {user.companyName}</p>
        <p><strong>University:</strong> {user.university}</p>
        <p><strong>Role:</strong> {user.role}</p>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onClose}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
}

export default UserModal;

