function UserCard({ user, onClick }) {
  return (
    <div className="card m-2 p-2" style={{ width: "18rem" }}>
      <img src={user.image} className="card-img-top" alt="User" />
      <div className="card-body">
        <h5 className="card-title">{user.firstName} {user.lastName}</h5>
        <p><strong>Email:</strong> {user.email}</p>
        <p>
          <strong>ID:</strong>{" "}
          <span
            style={{ color: "blue", cursor: "pointer", textDecoration: "underline" }}
            onClick={() => onClick(user.id)}
          >
            {user.id}
          </span>
        </p>
      </div>
    </div>
  );
}

export default UserCard;
