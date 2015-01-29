package it.unitn.ds.server;

import it.unitn.ds.util.StorageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class NodeUtilImpl extends UnicastRemoteObject implements NodeUtil {

    private static final Logger logger = LogManager.getLogger();

    private Node node;

    public NodeUtilImpl(Node node) throws RemoteException {
        this.node = node;
    }

    @Override
    public Node getNode() throws RemoteException {
        logger.debug("Get Node request=" + node);
        return node;
    }

    @Override
    public TreeSet<Integer> getNodes() throws RemoteException {
        logger.debug("Get Nodes request=" + Arrays.toString(node.getNodes().toArray()));
        return node.getNodes();
    }

    @Override
    public void addNode(int nodeId) throws RemoteException {
        logger.debug("Add node request with node=" + nodeId);
        node.getNodes().add(nodeId);
    }

    @Override
    public void removeNode(int nodeId) throws RemoteException {
        logger.debug("Remove node request with node=" + nodeId);
        node.getNodes().remove(nodeId);
    }

    @Override
    public void updateItems(List<Item> items) throws RemoteException {
        logger.debug("Update items request with items=" + Arrays.toString(items.toArray()));
        for (Item item : items) {
            StorageUtil.write(node, item);
        }
    }
}
